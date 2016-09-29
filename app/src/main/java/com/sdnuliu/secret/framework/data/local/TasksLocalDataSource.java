package com.sdnuliu.secret.framework.data.local;

import android.support.annotation.NonNull;

import com.sdnuliu.secret.framework.data.Task;
import com.sdnuliu.secret.framework.data.TasksDataSource;

/**
 * Created by liuteng on 16/9/29.
 */

public class TasksLocalDataSource implements TasksDataSource {
    private static TasksLocalDataSource INSTANCE;

    private TasksLocalDataSource() {

    }

    public static TasksLocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TasksLocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public void getTasks(@NonNull LoadTasksCallback callback) {

    }

    @Override
    public void getTask(@NonNull String taskId, @NonNull GetTaskCallback callback) {

    }

    @Override
    public void saveTask(@NonNull Task task) {

    }

    @Override
    public void completeTask(@NonNull Task task) {

    }

    @Override
    public void completeTask(@NonNull String taskId) {

    }

    @Override
    public void activateTask(@NonNull Task task) {

    }

    @Override
    public void activateTask(@NonNull String taskId) {

    }

    @Override
    public void clearCompletedTasks() {

    }

    @Override
    public void refreshTasks() {

    }

    @Override
    public void deleteAllTasks() {

    }

    @Override
    public void deleteTask(@NonNull String taskId) {

    }
}
