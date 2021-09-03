# Completed project for the Auth0 Developer Blog article *Get Started with Android Authentication using Kotlin and Auth0*

This repository contains the code for the completed project from the article in the Auth0 Developer Blog titled ***Get Started with Android Authentication using Kotlin and Auth0***.


## The Project: *Login*

*Login* is a simple, single-screen Android app where the user can  log in and log out using Auth0. While logged in, the user will be able to see the following information from their profile, namely:

* Information that is part and parcel of the user account, namely:
	* The user’s name
	* The user’s email address
* Metadata attached to the user account, namely:
	* The user’s country

The user will also be able to edit their country, and the result of that edit will be stored in the user account.

When not logged in, the app looks like this:

![“Login”’s screen when launched. The greeting “Welcome to the app!” appears above the “Log in” and “Log out” buttons.](https://images.ctfassets.net/23aumh6u8s0i/7FSXqzXczgaNUC5NnY9q1F/d72b55833d1bf446c70d60488f7f4ae0/welcome_screen.png)

When logged in, the app looks like this:

![“Login”’s screen when the user is logged in. It displays information about the logged-in user.](https://images.ctfassets.net/23aumh6u8s0i/6D4JdPU0s5tGuplX9gEE4g/cfb0e2c57ead91059a2d6a26d6efdf44/main_screen_1.png)


## How to Build the Project

### Prerequisites

You’ll need the following to build the project:

* **An Android development setup.** Make sure you have the following, in the order given below:
	* [**Java SE Developer Kit (JDK), version 11 or later.**](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html) You can find out which version is on your computer by opening a command-line interface and entering `java --version`.
	* [**Android Studio,**](https://developer.android.com/studio) version 3.6 (February 2020) or later. I used the current stable version of Android Studio when writing this article: version 2020.3.1, also known as “Arctic Fox”.
	* **At least one Android SDK (Software Development Kit) platform.** You can confirm that you have one (and install one if you don’t) in Android Studio. Open **Tools** → **SDK Manager**. You’ll see a list of Android SDK platforms. Make sure that the current SDK (**Android 11.0 (R)** at the time of writing) is checked; if it isn’t, check it, click the **Apply** button, and click the **OK**  button in the confirmation dialog that appears. Wait for the SDK platform to install and click the **Finish** button when installation is complete.
* **An Android device, real or virtual:**
	* **Using a real device:** Connect the device to your computer with a USB cable. [Make sure that your device has Developer Options and USB debugging enabled.](https://developer.android.com/studio/debug/dev-options)
	* **Using a virtual device:** Using Android Studio, you can build a virtual device (emulator) that runs on your computer. Here’s my recipe for a virtual device that simulates a current-model inexpensive Android phone:
		1. Open **Tools** → **AVD Manager** (AVD is short for “Android Virtual Device”). The **Your Virtual Devices** window will appear. Click the **Create Virtual Device...** button.
		2. The **Select Hardware** window will appear. In the **Phone** category, select **Pixel 3a** and click the **Next** button.
		3. The **System Image** window will appear, and you’ll see a list of Android versions. Select **R** (API 30, also known as Android 11.0). If you see a **Download** link beside R, click it, wait for the OS to download, then click the **Finish** button. Then click the **Next** button.
		4. The **Android Virtual Device (AVD)** window will appear. The **AVD Name** field should contain **Pixel 3a API 30**, the two rows below it should have the titles **Pixel 3a** and **R**, and in the **Startup orientation** section, **Portrait** should be selected. Click the **Finish** button.
		5. You will be back at the **Your Virtual Devices** window. The list will now contain **Pixel 3a API 30**, and that device will be available to you when you run the app.
* **An Auth0 account.** [You can sign up for a free one here.](https://auth0.com/sign-up?tr=1)


### Building the project

To build the project:

1. Download the repository into a local directory.
2. Open Android Studio.
3. Select **File** → **Open...**, then select the directory you downloaded the repository into.
4. Once the project has loaded and Gradle has performed its build tasks, select a device from the device drop-down menu and click the **Run** (▶️) button.