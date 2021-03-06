/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for JobState.
 */
public enum JobState {
    /** The Job is available to have Tasks scheduled. */
    ACTIVE("active"),

    /** A user has requested that the Job be disabled, but the disable operation is still in progress (for example, waiting for Tasks to terminate). */
    DISABLING("disabling"),

    /** A user has disabled the Job. No Tasks are running, and no new Tasks will be scheduled. */
    DISABLED("disabled"),

    /** A user has requested that the Job be enabled, but the enable operation is still in progress. */
    ENABLING("enabling"),

    /** The Job is about to complete, either because a Job Manager Task has completed or because the user has terminated the Job, but the terminate operation is still in progress (for example, because Job Release Tasks are running). */
    TERMINATING("terminating"),

    /** All Tasks have terminated, and the system will not accept any more Tasks or any further changes to the Job. */
    COMPLETED("completed"),

    /** A user has requested that the Job be deleted, but the delete operation is still in progress (for example, because the system is still terminating running Tasks). */
    DELETING("deleting");

    /** The actual serialized value for a JobState instance. */
    private String value;

    JobState(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a JobState instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed JobState object, or null if unable to parse.
     */
    @JsonCreator
    public static JobState fromString(String value) {
        JobState[] items = JobState.values();
        for (JobState item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
