package com.zillow.platform.u202417468.pc4307u202417468.monitoring.domain.model.commands;

/**
 * Command for creating new alerts within the monitoring bounded context.
 * Encapsulates alert creation data including satellite identification and alert
 * classification
 * for system monitoring and notification purposes.
 * 
 * @param satelliteCode the satellite identifier as a string (must be valid UUID
 *                      format)
 * @param alertType     the alert classification (UNSAFE_ORBIT_TASK,
 *                      NODE_COMMUNICATION_LOST, SYSTEM_ERROR, OTHER)
 * 
 * @author Fabrizzio Pereira – Code: U202417468
 */
public record CreateAlertsCommand(
        String satelliteCode,
        String alertType) {

}
