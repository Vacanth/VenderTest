package org.springframework.batch.admin.category;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class CategoryStepExeListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {

		return null;
	}
}