/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.costmanagement.v2018_05_31;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The definition of a report config.
 */
public class ReportConfigDefinition {
    /**
     * The type of the report.
     */
    @JsonProperty(value = "type", required = true)
    private String type;

    /**
     * The time frame for pulling data for the report. If custom, then a
     * specific time period must be provided. Possible values include:
     * 'WeekToDate', 'MonthToDate', 'YearToDate', 'Custom'.
     */
    @JsonProperty(value = "timeframe", required = true)
    private TimeframeType timeframe;

    /**
     * Has time period for pulling data for the report.
     */
    @JsonProperty(value = "timePeriod")
    private ReportConfigTimePeriod timePeriod;

    /**
     * Has definition for data in this report config.
     */
    @JsonProperty(value = "dataset")
    private ReportConfigDataset dataset;

    /**
     * Creates an instance of ReportConfigDefinition class.
     * @param timeframe the time frame for pulling data for the report. If custom, then a specific time period must be provided. Possible values include: 'WeekToDate', 'MonthToDate', 'YearToDate', 'Custom'.
     */
    public ReportConfigDefinition() {
        type = "Usage";
    }

    /**
     * Get the type of the report.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

    /**
     * Set the type of the report.
     *
     * @param type the type value to set
     * @return the ReportConfigDefinition object itself.
     */
    public ReportConfigDefinition withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the time frame for pulling data for the report. If custom, then a specific time period must be provided. Possible values include: 'WeekToDate', 'MonthToDate', 'YearToDate', 'Custom'.
     *
     * @return the timeframe value
     */
    public TimeframeType timeframe() {
        return this.timeframe;
    }

    /**
     * Set the time frame for pulling data for the report. If custom, then a specific time period must be provided. Possible values include: 'WeekToDate', 'MonthToDate', 'YearToDate', 'Custom'.
     *
     * @param timeframe the timeframe value to set
     * @return the ReportConfigDefinition object itself.
     */
    public ReportConfigDefinition withTimeframe(TimeframeType timeframe) {
        this.timeframe = timeframe;
        return this;
    }

    /**
     * Get has time period for pulling data for the report.
     *
     * @return the timePeriod value
     */
    public ReportConfigTimePeriod timePeriod() {
        return this.timePeriod;
    }

    /**
     * Set has time period for pulling data for the report.
     *
     * @param timePeriod the timePeriod value to set
     * @return the ReportConfigDefinition object itself.
     */
    public ReportConfigDefinition withTimePeriod(ReportConfigTimePeriod timePeriod) {
        this.timePeriod = timePeriod;
        return this;
    }

    /**
     * Get has definition for data in this report config.
     *
     * @return the dataset value
     */
    public ReportConfigDataset dataset() {
        return this.dataset;
    }

    /**
     * Set has definition for data in this report config.
     *
     * @param dataset the dataset value to set
     * @return the ReportConfigDefinition object itself.
     */
    public ReportConfigDefinition withDataset(ReportConfigDataset dataset) {
        this.dataset = dataset;
        return this;
    }

}
