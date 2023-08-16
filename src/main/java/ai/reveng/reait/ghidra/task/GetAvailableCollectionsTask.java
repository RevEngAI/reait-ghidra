package ai.reveng.reait.ghidra.task;

import org.json.JSONArray;
import org.json.JSONException;

import ai.reveng.reait.exceptions.REAIApiException;
import ai.reveng.reait.ghidra.REAITHelper;
import ghidra.util.exception.CancelledException;
import ghidra.util.task.Task;
import ghidra.util.task.TaskMonitor;

public class GetAvailableCollectionsTask extends Task {
	private TaskCallback<JSONArray> callback;

	public GetAvailableCollectionsTask(TaskCallback<JSONArray> callback) {
		super("Get Collections", true, false, false);
		this.callback = callback;
	}

	@Override
	public void run(TaskMonitor monitor) throws CancelledException {
		try {
			JSONArray result = REAITHelper.getInstance().getClient().status();
			callback.onTaskCompleted(result);
		} catch (JSONException | REAIApiException e) {
			callback.onTaskError(e);
		}

	}
}