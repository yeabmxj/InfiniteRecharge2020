/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.Autonomous.Simple.CrossLine;
import frc.Commands.Climber.*;
import frc.Commands.Drivetrain.*;
import frc.Commands.Groups.CapacityBasedIntake;
import frc.Commands.Intaker.*;
import frc.Commands.Shooter.*;
import frc.Commands.Spinner.*;
import frc.Commands.Storage.*;
import frc.Subsystems.*;

import static frc.Configuration.Constants.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  //Joystick
  private static Joystick joy = new Joystick(0);
  private double xAxis = joy.getRawAxis(JOYSTICK_X_AXIS);
  private double yAxis = joy.getRawAxis(JOYSTICK_Y_AXIS);

  //Subsystems
  public final Climber climber = new Climber();
  public final Drivetrain drivetrain = new Drivetrain();
  public final Intaker intaker = new Intaker();
  public final Limelight limelight = new Limelight();
  public final NavX navX = new NavX();
  public final PDP pdp = new PDP();
  public final Shooter shooter = new Shooter();
  public final Spinner spinner = new Spinner();
  public final Storage storage = new Storage();

  //Climb
  public final ExtendLift extendLift = new ExtendLift(climber);
  public final StopLift stopLift = new StopLift(climber);
  public final RetractLift retractLift = new RetractLift(climber);

  //Drive
  public final CappedDrive cappedDrive = new CappedDrive(drivetrain, xAxis, yAxis, drivetrain.getThrottle());
  public final Drive drive = new Drive(drivetrain, xAxis, yAxis, drivetrain.getThrottle());
  public final StopDrive stopDrive = new StopDrive(drivetrain);

  //Intake
  public final Intake intake = new Intake(intaker);
  public final StopIntake stopIntake = new StopIntake(intaker);

  //Shooter
  public final Shoot shoot = new Shoot();
  public final StopShooting stopShooting = new StopShooting();

  //Spinner
  public final PositionControl positionControl = new PositionControl(spinner);
  public final RotationControl rotationControl = new RotationControl(spinner);
  public final Spin spin = new Spin(spinner);
  public final StopSpin stopSpin = new StopSpin(spinner);

  //Storage
  public final ActuateStorage actuateStorage = new ActuateStorage(storage);
  public final DecrementBallCount decrementBallCount = new DecrementBallCount(storage);
  public final FullCapacity fullCapacity = new FullCapacity(storage);
  public final HaltStorage haltStorage = new HaltStorage(storage);
  public final IncrementBallCount incrementBallCount = new IncrementBallCount(storage);
  public final CapacityBasedIntake capacityBasedIntake = new CapacityBasedIntake(fullCapacity, intake);

  //Auto
  public final CrossLine crossLine = new CrossLine();

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private Button intakeBTN = new JoystickButton(joy, INTAKE_BUTTON);
  private Button shootBTN = new JoystickButton(joy, SHOOT_BUTTON);
  private Button climbBTN = new JoystickButton(joy, CLIMB_BUTTON);
  private Button spinBTN = new JoystickButton(joy, SPINNER_BUTTON);
  private Button incThrotBTN = new JoystickButton(joy, INCREASE_THROTTLE_BUTTON);
  private Button decThrotBTN = new JoystickButton(joy, DECREASE_THROTTLE_BUTTON);

  //todo add actual button binds
  private void configureButtonBindings() {
    intakeBTN.whenPressed(intake);
    shootBTN.whenPressed(new InstantCommand(shooter::shoot));
    climbBTN.whenPressed(extendLift);
    spinBTN.whenPressed(positionControl);
    incThrotBTN.whenPressed(new InstantCommand(drivetrain::increaseThrottle));
    decThrotBTN.whenPressed(new InstantCommand(drivetrain::decreaseThrottle));
  }

  public void startTeleop() {
    capacityBasedIntake.schedule();
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return (Command) crossLine;
  }
}
