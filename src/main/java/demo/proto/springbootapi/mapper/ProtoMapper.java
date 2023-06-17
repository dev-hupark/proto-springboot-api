package demo.proto.springbootapi.mapper;

import demo.proto.springbootapi.model.ProtoVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProtoMapper {
    List<ProtoVO> selectProto();
}
