package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

// General Motor Control
// Must pass in a Hardware Map

// Example:
public class GeneralDrive {
    private DcMotor motor0 = null;
    private DcMotor motor1 = null;
    private DcMotor motor2 = null;
    private DcMotor motor3 = null;
    private HardwareMap hardwareMap;

    public GeneralDrive(HardwareMap hwMap) {
        this.hardwareMap = hwMap;
        init();
    }

    private void init() {
        motor0  = hardwareMap.get(DcMotor.class, "motor0");
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");
        motor3 = hardwareMap.get(DcMotor.class, "motor3");

        motor0.setDirection(DcMotor.Direction.REVERSE);
        motor1.setDirection(DcMotor.Direction.FORWARD);
        motor2.setDirection(DcMotor.Direction.REVERSE);
        motor3.setDirection(DcMotor.Direction.FORWARD);
    }

    public void setMotor0(double power){
        motor0.setPower(power);
    }

    public void setMotor1(double power){
        motor1.setPower(power);
    }

    public void setMotor2(double power){
        motor2.setPower(power);
    }
    
    public void setMotor3(double power){
        motor3.setPower(power);
    }

    public void moveForward(double power) {
        setMotor0(power);
        setMotor1(power);
        setMotor2(power);
        setMotor3(power);
    }

    public void moveBackward(double power) {
        setMotor0(-power);
        setMotor1(-power);
        setMotor2(-power);
        setMotor3(-power);
    }

    public void stopMotors(){
        motor0.setPower(0);
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
    }

    public void turnLeft(double power) {
        setMotor0(-power);
        setMotor1(power);
        setMotor2(-power);
        setMotor3(power);
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
        setMotor0(power);
        setMotor1(-power);
        setMotor2(power);
        setMotor3(-power);
    }

    public void turnRight90() {
        try {
            turnRight(1);
            Thread.sleep(350); // Can be interrupted
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Preserve interrupt status
        } finally {
            stopMotors(); // Ensure motors stop even if interrupted
        }
    }
}
