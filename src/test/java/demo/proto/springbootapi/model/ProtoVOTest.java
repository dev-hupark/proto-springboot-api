package demo.proto.springbootapi.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProtoVOTest {
    @Test
    public void lombok_test() {
        String id = "admin";
        String todo = "todo!";

        ProtoVO vo = new ProtoVO(id, todo);

        assertThat(vo.getId()).isEqualTo(id);
        assertThat(vo.getTodo()).isEqualTo(todo);
    }
}
