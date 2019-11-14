package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevSPARKMini;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.internal.android.dex.EncodedValueReader;
import java.util.Base64;

@TeleOp
public class MyFIRSTJavaOpMode extends LinearOpMode {
    private DcMotor BackRight;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor FrontLeft;
    // private DcMotorSimple Elevator;
    private DcMotorSimple Intake;
    // private Servo flippy;


    @Override
    public void runOpMode() {
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        // Elevator = hardwareMap.get(DcMotorSimple.class, "Elevator");
        // Elevator.setDirection(DcMotorSimple.Direction.FORWARD);
        Intake = hardwareMap.get (DcMotorSimple.class,  "Intake");
        Intake.setDirection(DcMotorSimple.Direction.FORWARD);
        // flippy = hardwareMap.get(Servo.class, "ServoMotor");

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)
        double left= 0;
        double right = 0;
        boolean dpadLeft, dpadRight, dpadDown, dpadUp, leftBumper, rightBumper = true;
        float leftTrigger, rightTrigger = 0;

        while (opModeIsActive()) {
            left = this.gamepad1.left_stick_y;
            right = -this.gamepad1.right_stick_y;
            // dpadLeft = this.gamepad1.dpad_left;
            // dpadRight = this.gamepad1.dpad_right;
            // dpadUp = this.gamepad1.dpad_up;
            // dpadDown = this.gamepad1.dpad_down;
            leftBumper = this.gamepad1.left_bumper;
            rightBumper = this.gamepad1.right_bumper;
            //maybe set up some triggers if necessary, possibly for
            leftTrigger = this.gamepad1.left_trigger * (float)0.75;
            rightTrigger = this.gamepad1.right_trigger * (float)0.75;

            /* if (dpadUp){
                Elevator.setPower(.5);
            }
            else if (dpadDown){
                Elevator.setPower (-.5);
            }
            else {
                Elevator.setPower (0);
            } */


            if (rightBumper){
                Intake.setPower(0.64);  // was set to 0.5, new set to 0.65
            }
            else if (leftBumper){
                Intake.setPower(-0.65);  // was set to -0.5, new set to -0.65
            }
            else if (rightTrigger > 0 ) {
                Intake.setPower(rightTrigger);
            }
            else if (leftTrigger > 0 ) {
                Intake.setPower(-leftTrigger);
            }
            else {
                Intake.setPower(0);
            }




            /* if (rightBumper) {
                flippy.setPosition(1.0);
            }
            else if (leftBumper) {
                flippy.setPosition(0.0);
            } */


            BackLeft.setPower(-left);
            FrontLeft.setPower(-left);
            BackRight.setPower(-right);
            FrontRight.setPower(-right);
            telemetry.addData("Left Power",-left);
            telemetry.addData("Right Power",-right);
            telemetry.addData("Left Bumper", leftBumper);
            telemetry.addData("Right Bumper", rightBumper);
            telemetry.addData("Left Trigger", leftTrigger);
            telemetry.addData("Right Trigger", rightTrigger);
            // telemetry.addData("Servo Position", flippy.getPosition());
            telemetry.update();
        }
    }
}

