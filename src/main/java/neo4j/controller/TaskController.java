package neo4j.controller;

import neo4j.model.Task;
import neo4j.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/8/11
 * @description
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = "application/json")
    @Transactional
    public Task saveTask(@RequestBody Task taskInfo) {
        Task task = taskRepository.save(taskInfo);
        return task;
    }



    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Task create(@PathVariable String name) {
        Task task = taskRepository.findByTaskName(name);
        return task;
    }
}
