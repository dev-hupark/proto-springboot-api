package demo.proto.springbootapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProtoVO {
    private final String id;
    private final String todo;
}
