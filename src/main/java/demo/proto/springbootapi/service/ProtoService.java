package demo.proto.springbootapi.service;

import demo.proto.springbootapi.mapper.ProtoMapper;
import demo.proto.springbootapi.model.ProtoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProtoService{
    @Autowired
    public ProtoMapper mapper;

    public List<ProtoVO> selectProto() {
        return mapper.selectProto();
    }
}
