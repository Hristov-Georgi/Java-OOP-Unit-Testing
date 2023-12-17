package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class AlarmTest {
    private static final double HIGH_PRESSURE_VALUE = 34.23;
    private static final double LOW_PRESSURE_VALUE = 14.34;

    private Alarm alarm;

    @Test
    public void testAlarmIsOnForHighPressure() {
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(mockedSensor);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE );
        this.alarm.check();

        Assert.assertTrue(this.alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnForLowPressure() {
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        this.alarm = new Alarm(mockedSensor);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);
        this.alarm.check();

        Assert.assertTrue(this.alarm.getAlarmOn());

    }

}
