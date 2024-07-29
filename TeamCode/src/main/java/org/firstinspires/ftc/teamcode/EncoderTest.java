package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class EncoderTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Find a motor in the hardware map named "Arm Motor"
        DcMotor motor = hardwareMap.dcMotor.get("motor0");

        // Reset the motor encoder so that it reads zero ticks
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Turn the motor back on, required if you use STOP_AND_RESET_ENCODER
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while (opModeIsActive()) {
            double maxSpeed = 1.0;
            double power=0;
            // Get the current position of the motor
            double position = motor.getCurrentPosition();

            if (Math.abs(gamepad1.right_stick_y)>0.2){
                power = gamepad1.right_stick_y;
            }
            else if(gamepad1.a && position!=0){
                if(Math.abs(position)>0.5) {
                    power = -position / 1000.0;
                }
                if(power<0.25){
                    power = 0.25;
                }
            }
            else {
                power = 0;
            }
            power = power*maxSpeed;
            if(power>maxSpeed){
                power = maxSpeed;
            }
            motor.setPower(power);

            // Show the position of the motor on telemetry
            telemetry.addData("Encoder Position", position);
            telemetry.addData("Speed: ", power);
            telemetry.update();
        }
    }
}