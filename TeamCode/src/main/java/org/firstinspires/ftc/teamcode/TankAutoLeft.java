package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class TankAutoLeft extends LinearOpMode{
    private DcMotor BackRight;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor FrontLeft;

    @Override
    public void runOpMode() {

        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");


        waitForStart();


        BackLeft.setPower(-0.85);
        FrontLeft.setPower(-0.85);
        BackRight.setPower(-0.85);
        FrontRight.setPower(-0.85);
        //turn left
        sleep(462);
        //wait for about 0.350 seconds

        BackLeft.setPower(0);
        FrontLeft.setPower(0);
        BackRight.setPower(0);
        FrontRight.setPower(0);
        // stop
        sleep(1000);
        // wait for 1 second

        BackLeft.setPower(1);
        FrontLeft.setPower(1);
        BackRight.setPower(-1);
        FrontRight.setPower(-1);
        // go forward
        sleep(275);
        // wait for some time NOTE TO SELF PLEASE TEST THIS VALUE

        BackLeft.setPower(0);
        FrontLeft.setPower(0);
        BackRight.setPower(0);
        FrontRight.setPower(0);

        sleep(30000);
    }

}
