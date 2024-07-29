package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class NoFrontRight extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        // Declare our motors
        // Make sure your ID's match your configuration
        // Note: The front left motor is considered disabled and thus not initialized
        DcMotor backLeftMotor = hardwareMap.dcMotor.get("motor1");
        DcMotor frontRightMotor = hardwareMap.dcMotor.get("motor2");
        DcMotor backRightMotor = hardwareMap.dcMotor.get("motor3");

        // Reverse the right side motors. Adjust this based on your robot's configuration.
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = -gamepad1.left_stick_y; // Y stick value is reversed
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            // Adjust the powers to compensate for the missing front left motor
            // The idea is to adjust the remaining motors to take over some of the missing motor's responsibilities
            double backLeftPower = y - rx; // Adjusted to take over some forward and rotational movement
            double frontRightPower = y - x - rx; // Slightly more power to assist with forward movement and turning
            double backRightPower = y + x - rx; // Adjusted to help with strafing and turning

            // No need to calculate the front left power as the motor is disabled

            // Set power to the motors
            backLeftMotor.setPower(backLeftPower);
            frontRightMotor.setPower(frontRightPower);
            backRightMotor.setPower(backRightPower);
        }
    }
}
