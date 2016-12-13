package au.com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import au.com.test.model.Worker;
import au.com.test.model.WorkerJobMatch;
import au.com.test.service.JobService;

@RestController
@RequestMapping("/jobs")
public class JobsMatcherController {

	private JobService workerService;
	
	@Autowired
	public JobsMatcherController(JobService workerService) {
		this.workerService = workerService;
	}
	
	@RequestMapping("/workers/list")
    List<Worker> list() {
        return workerService.getWorkers();
    }
	
	@RequestMapping("/{workerId}/match")
    WorkerJobMatch matchJobs(@PathVariable("workerId") Integer workerId) {
        return workerService.matchJobs(workerId);
    }
}
