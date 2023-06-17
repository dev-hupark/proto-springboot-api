package demo.proto.springbootapi.controller;

import demo.proto.springbootapi.model.ProtoVO;
import demo.proto.springbootapi.service.ProtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProtoController {
    @Autowired
    ProtoService protoService;

    @RequestMapping(value = "/")
    @ResponseBody
    public ResponseEntity<List<ProtoVO>> test() throws Exception{
        List<ProtoVO> protoList = protoService.selectProto();
        return ResponseEntity.status(HttpStatus.OK).body(protoList);
    }
}
