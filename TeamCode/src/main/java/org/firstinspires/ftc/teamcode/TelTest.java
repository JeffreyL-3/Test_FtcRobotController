package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//Driver-Controlled Period
@TeleOp
public class TelTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        GeneralDrive myRobot = new GeneralDrive(hardwareMap);
        Telemetry telemetry;
        telemetry = this.telemetry;

        waitForStart();

        while ( opModeIsActive() ) {

            //Down
            if (gamepad1.right_trigger>0){
                telemetry.addData("Status", "Going down...");
                telemetry.update();

            }

            //Out
            if (gamepad1.left_trigger>0) {
                telemetry.addData("Status", "Going out...");
                telemetry.update();
            }
        }
    }
}

