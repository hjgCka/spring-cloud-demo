package com.hjg.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @author: hjg
 * @createdOn: 2021/11/9
 */
@RestController
public class InvokerController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    /**
     * 使用http://localhost:8082/router?name=James来访问，可以得到UserController的结果。
     * @param name
     * @return
     */
    @RequestMapping(value = "/router")
    public String router(String name) {
        return restTemplate.getForObject("http://provider/hello?name="+name, String.class);
    }

    /**
     * 使用DiscoveryClient客户端。
     * @return
     */
    @RequestMapping(value = "/meta-info")
    public Map<String, String> metaData() {
        Map<String, String> result = new HashMap<>();

        List<String> list = discoveryClient.getServices();
        result.put("serviceList", list.stream().collect(Collectors.joining("_")));

        List<ServiceInstance> instanceList = discoveryClient.getInstances("provider");
        for(ServiceInstance instance : instanceList) {

            result.put("instanceId", instance.getInstanceId());
            result.put("host", instance.getHost());
            result.put("port", instance.getPort()+"");
            result.put("serviceId", instance.getServiceId());

            Map<String, String> metaMap = instance.getMetadata();
            String keys = metaMap.keySet().stream().collect(Collectors.joining("_"));
            result.put("keys", keys);
            String values = metaMap.values().stream().collect(Collectors.joining("_"));
            result.put("values", values);
        }

        return result;
    }
}
