package demo.proto.springbootapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.proto.springbootapi.domain.todos.Todos;
import demo.proto.springbootapi.domain.todos.TodosRepository;
import demo.proto.springbootapi.model.TodoSaveReqDto;
import demo.proto.springbootapi.model.TodoUpdateReqDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TodosRepository todosRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
    @After
    public void tearDown() throws Exception {
        todosRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void Todos_save() throws Exception {
        String todo = "todo";
        String memo = "memo";

        TodoSaveReqDto requestDto = TodoSaveReqDto.builder().todo(todo).memo(memo).build();

        String url = "http://localhost:"+port + "/api/v1/todos/";

        /*ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);*/

        mvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                        .andExpect(status().isOk());


        List<Todos> all = todosRepository.findAll();
        assertThat(all.get(0).getTodo()).isEqualTo(todo);
        assertThat(all.get(0).getMemo()).isEqualTo(memo);

    }

    @Test
    @WithMockUser(roles = "USER")
    public void Todos_modify() throws Exception {
        Todos savedTodos = todosRepository.save(Todos.builder().todo("todo!!").memo("memo!!").build());

        Long updateId = savedTodos.getId();
        String expectedTodo = "todo2";
        String expectedMemo = "memo2";

        TodoUpdateReqDto requestDto = TodoUpdateReqDto.builder().todo(expectedTodo).memo(expectedMemo).build();

        String url = "http://localhost:"+port + "/api/v1/todos/" + updateId;

        /*HttpEntity<TodoUpdateReqDto> requestEntity = new HttpEntity<>(requestDto);
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);*/

        mvc.perform(put(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(requestDto)))
                        .andExpect(status().isOk());

        List<Todos> all = todosRepository.findAll();
        assertThat(all.get(0).getTodo()).isEqualTo(expectedTodo);
        assertThat(all.get(0).getMemo()).isEqualTo(expectedMemo);


    }
}
