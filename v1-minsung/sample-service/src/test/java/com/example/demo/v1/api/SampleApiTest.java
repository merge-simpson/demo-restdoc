package com.example.demo.v1.api;

import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.example.demo.v1.api.SampleApi.SampleRequestDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.requestFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc   // MockMvcBuilders.webAppContextSetup(webApplicationContext) ... .build()
@AutoConfigureRestDocs  // .apply(documentationConfiguration(restDocumentation))
@ExtendWith(SpringExtension.class)
class SampleApiTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private Gson gson;

    @Test
    public void test() throws Exception {
        SampleRequestDto dto = new SampleRequestDto("홍길동", 17);

        ResultActions perform = this.mockMvc.perform(
                post("/")
                                .content(gson.toJson(dto)) // {"name": "홍길동", "age": 17}
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
//                        .with(csrf())
                )
                .andExpect(status().is2xxSuccessful());

        perform.andDo(print())
                .andDo(
                        // Rest Docs
                        document("my-sample-api-identifier",
                                // pathParameters(parameterWithName("").description(""), ... ),
                                requestFields(
                                        fieldWithPath("name").description("이름"),
                                        fieldWithPath("age").description("나이")
                                ),
                                responseFields(
                                        fieldWithPath("success").description("성공")
                                )
                        )
                )
                .andDo(
                        // Swagger
                        document("sample",
                                preprocessRequest(prettyPrint()),
                                preprocessResponse(prettyPrint()),
                                resource(
                                        ResourceSnippetParameters.builder()
                                                .summary("API 설명 요약입니다.")
                                                .description("이것이 바로 API 설명입니다.")
                                                // .pathParameters(parameterWithName("").description(""), ... ),
                                                .requestFields(
                                                        fieldWithPath("name").description("이름"),
                                                        fieldWithPath("age").description("나이")
                                                )
                                                .responseFields(
                                                        fieldWithPath("success").description("성공")
                                                )
                                                .build()
                                )
                        )
                );
    }
}