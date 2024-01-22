package org.firstinspires.ftc.teamcode.control;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

//General Motor Control
//Must pass in a Hardware Map

//Example:
public class GeneralDrive{
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private HardwareMap hardwareMap;

    public GeneralDrive(HardwareMap hwMap) {
        this.hardwareMap = hwMap;
        init();
    }
    private void init() {
        leftDrive  = hardwareMap.get(DcMotor.class, "motor0");
        rightDrive = hardwareMap.get(DcMotor.class, "motor1");

        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);
    }

    public void setLeftDrivePower(double power){
        leftDrive.setPower(power);
    }

    public void setRightDrivePower(double power){
        rightDrive.setPower(power);
    }

    public void moveForward(double power) {
        setLeftDrivePower(power);
        setRightDrivePower(power);
    }

    public void moveBackward(double power) {
        setLeftDrivePower(-power);
        setRightDrivePower(-power);
    }

    public void stopMotors(){
        moveForward(0);
    }

    public void turnLeft(double power) {
        setLeftDrivePower(power);
        setRightDrivePower(-power);
    }

    public void turnLeft90() {
        try {
            turnLeft(1);
            Thread.sleep(350); // Can be interrupted
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
        } finally {
            stopMotors(); // Ensure motors stop even if interrupted
        }
    }


    public void turnRight(double power) {
        setLeftDrivePower(-power);
        setRightDrivePower(power);
    }

    public void turnRight90() {
        try {
            turnRight(1);
            Thread.sleep(350); // Can be interrupted
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
        }
        finally {
            stopMotors(); // Ensure motors stop even if interrupted
        }
    }


}

