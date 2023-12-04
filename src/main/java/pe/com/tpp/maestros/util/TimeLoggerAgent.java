package pe.com.tpp.maestros.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Component
public class TimeLoggerAgent {
	private static final Logger TIMES_LOGGER = LoggerFactory.getLogger("TIME_LOGGER");

	private SimpleDateFormat formatter = new SimpleDateFormat(Constants.TIME_LOGGER_FORMAT_HOUR);

	private Calendar zeroTime;

	public TimeLoggerAgent() {

		zeroTime = Calendar.getInstance();
		zeroTime.set(Calendar.HOUR_OF_DAY, 0);
		zeroTime.set(Calendar.MINUTE, 0);
		zeroTime.set(Calendar.SECOND, 0);
		zeroTime.set(Calendar.MILLISECOND, 0);
	}

	private String getTimeFormatted(long time) {
		return formatter.format((time == 0) ? zeroTime.getTime() : new Date(time));
	}

	public void logService(TimeRecord timeRecord) {
		try {
			MDC.put(Constants.CORRELATION_ID_MDC, timeRecord.getCorrelationId());
			MDC.put(Constants.TYPE_MDC, timeRecord.getType());
			MDC.put(Constants.ENDPOINT_MDC, timeRecord.getEndPoint());

			MDC.put(Constants.START_TIME_MDC, this.getTimeFormatted(timeRecord.getStartTime()));
			MDC.put(Constants.END_TIME_MDC, this.getTimeFormatted(timeRecord.getEndTime()));

			MDC.put(Constants.STATUS_MDC, timeRecord.getStatus());
			MDC.put(Constants.SERVICE_PATH_MDC, timeRecord.getServicePath());

			if (timeRecord.getStatus().equalsIgnoreCase("500")) {

				MDC.put(Constants.TYPE_ERROR_MDC, timeRecord.getTypeError());
				MDC.put(Constants.MESSAGE_MDC, timeRecord.getMessage());
				MDC.put(Constants.STACK_TRACE1_MDC, timeRecord.getStackTrace1());
				MDC.put(Constants.STACK_TRACE2_MDC, timeRecord.getStackTrace2());

				TIMES_LOGGER.error(timeRecord.getType());
			} else {
				MDC.put(Constants.TYPE_ERROR_MDC, "OK");
				MDC.put(Constants.MESSAGE_MDC, "OK");
				MDC.put(Constants.STACK_TRACE1_MDC, "OK");
				MDC.put(Constants.STACK_TRACE2_MDC, "OK");

				TIMES_LOGGER.info(timeRecord.getType());
			}

		} catch (Exception e) {
			TIMES_LOGGER.error("Error al guardar TimeLogger.", e);
		} finally {
			MDC.remove(Constants.CORRELATION_ID_MDC);
			MDC.remove(Constants.TYPE_MDC);
			MDC.remove(Constants.ENDPOINT_MDC);
			MDC.remove(Constants.START_TIME_MDC);
			MDC.remove(Constants.STATUS_MDC);
			MDC.remove(Constants.SERVICE_PATH_MDC);
			MDC.remove(Constants.TYPE_ERROR_MDC);
			MDC.remove(Constants.MESSAGE_MDC);
			MDC.remove(Constants.STACK_TRACE1_MDC);
			MDC.remove(Constants.STACK_TRACE2_MDC);

		}
	}
}
