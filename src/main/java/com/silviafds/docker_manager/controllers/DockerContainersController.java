package com.silviafds.docker_manager.controllers;

import com.github.dockerjava.api.model.Config;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Image;
import com.silviafds.docker_manager.services.DockerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
public class DockerContainersController {

    private final DockerService dockerService;

    public DockerContainersController(DockerService dockerService) {
        this.dockerService = dockerService;
    }


    @GetMapping("")
    public List<Container> listContainers(@RequestParam(required = false, defaultValue = "true") boolean showAll) {
        return dockerService.listContainers(showAll);
    }

    @PostMapping("/{id}/start")
    public void startContainer(@PathVariable String id) {
        dockerService.startContainer(id);
    }

}
