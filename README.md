# Completed project for the Auth0 Developer Blog article *Get Started with Android Authentication using Kotlin and Auth0*

This repository contains the code for the completed project from the article in the Auth0 Developer Blog titled ***Get Started with Android Authentication using Kotlin and Auth0***.

The article shows the reader how to use Auth0 to add fully-featured login and logout to an Android app writing in Kotlin. These projects are the initial and final version of the app featured in the article.

The project is for a single-screen Android app that allows users to log in and log out. It was purposely kept as simple as possible to keep the focus on authentication.


## A quick tour of the app

When launched, the app displays a screen with a greeting, a **Log In** button, and a disabled **Log Out** button:

![The app’s “Welcome” screen. The “Log In” button is enabled, and the “Log In” button is disabled.](https://images.ctfassets.net/23aumh6u8s0i/5rQ3FxlB0gfZx19Vcx43dP/8446f93ff34b9969181a2773a0037dc7/welcome_screen.png)

Pressing the **Log In** button starts the process that leads to the [Auth0 Universal Login screen](https://auth0.com/docs/login/universal-login):

![The default Auth0 Universal Login web page, with Auth0 logo and “email address” and “password” fields.](https://images.ctfassets.net/23aumh6u8s0i/6s273BfhhjTQIuE28lBATj/dd80dddaad0a2dd2909c43335924cbeb/universal_login_on_emulator.png)

When the user enters a valid email address/password combination, Auth0 authenticates the user, the Universal Login disappears, and the app displays information about the user:

![The app in its “logged in” state. The “Log In” button is disabled, “Log Out” button is enabled, and the app’s other controls are visible.](https://images.ctfassets.net/23aumh6u8s0i/3ZSDcJTymsLEzcUGaufsi/76d9c143ec91c3aae8b3746671f7bbc3/logged_in_screen.png)

Pressing the **Log Out** button logs the user out, taking them back to the opening screen, which informs the user that they’ve logged out:

![The app in its “logged out” state. The “Log In” button is enabled, “Log Out” button is disabled, and the app’s other controls are hidden.](https://images.ctfassets.net/23aumh6u8s0i/5YISprqJjBLtGRrIJGAO4h/2b59056f34a7cab636f42663547fe8d2/logged_out_screen.png)


## How to install and run the projects

### Prerequisites

You’ll need the following:

1. **An Auth0 account.** The app uses Auth0 to provide authenticate users, which means that you need an Auth0 account. You can <a href="https://auth0.com/signup" 
  data-amp-replace="CLIENT_ID" 
  data-amp-addparams="anonId=CLIENT_ID(cid-scope-cookie-fallback-name)">
  sign up for a free account</a>, which lets you add login/logout to 10 applications, with support for 7,000 users and unlimited logins. This should suit your prototyping, development, and testing needs.
2. **An Android development setup:** 
	* Any computer running Linux, macOS, or Windows from 2013 or later with at least 8 GB RAM. When it comes to RAM, more is generally better.
	* [**Java SE Developer Kit (JDK), version 11 or later.**](https://www.oracle.com/java/technologies/javase-jdk16-downloads.html) You can find out which version is on your computer by opening a command-line interface and entering `java --version`.
	* [**Android Studio,**](https://developer.android.com/studio) version 3.6 (February 2020) or later. I used the current stable version of Android Studio when writing this article: version 2021.2.1, also known as “Chipmunk”.
	* **At least one Android SDK (Software Development Kit) platform.** You can confirm that you have one (and install one if you don’t) in Android Studio. Open **Tools → SDK Manager**. You’ll see a list of Android SDK platforms. Make sure that the current SDK (**Android 11.0 (R)** at the time of writing) is checked; if it isn’t, check it, click the **Apply** button, and click the **OK** button in the confirmation dialog that appears. Wait for the SDK platform to install and click the **Finish** button when installation is complete.
	* **An Android device, real or virtual:**
		* **Using a real device:** Connect the device to your computer with a USB cable. Make sure that your device has Developer Options and USB debugging enabled.
		* **Using a virtual device:** Using Android Studio, you can build a virtual device (emulator) that runs on your computer. Here’s my recipe for a virtual device that simulates a current-model inexpensive Android phone:
			1. Open **Tools → AVD Manager** (AVD is short for “Android Virtual Device”). The **Your Virtual Devices** window will appear. Click the **Create Virtual Device...** button.
			2. The **Select Hardware** window will appear. In the **Phone** category, select **Pixel 3a** and click the **Next** button.
			3. The **System Image** window will appear, and you’ll see a list of Android versions. Select **R** (API 30, also known as Android 11.0). If you see a **Download** link beside R, click it, wait for the OS to download, then click the **Finish** button. Then click the **Next** button.
			4. The **Android Virtual Device (AVD)** window will appear. The **AVD Name** field should contain **Pixel 3a API 30**, the two rows below it should have the titles **Pixel 3a** (a reasonable “representative” phone, released 3 years ago at the time of writing) and **R**, and in the **Startup orientation** section, **Portrait** should be selected. Click the **Finish** button.
			5. You will be back at the **Your Virtual Devices** window. The list will now contain **Pixel 3a API 30**, and that device will be available to you when you run the app.


### Using the starter project

This project is meant to be the starting point for the article’s exercise. It’s not complete, but it _will_ run.

To use the starter project, download it and follow the article’s instructions.
	
			
### Running the complete project

The complete project is the result of downloading the start project and following the article’s instructions. It is provided for reference.

To use the complete project, download it, then connect it to Auth0 by doing the following:

* **Register the app in the Auth0 Dashboard:**
	* Log into the [Auth0 dashboard](https://manage.auth0.com/dashboard/), select **Applications → Applications** from the left side menu, then click the **Create Application** button.
	* Enter a name for the app in the **Name** field and choose the **Native** application type.
	* Select the **Settings** tab and copy the **Domain** and **Client ID** values.
	* Scroll down the **Settings** page and paste `app://{YOUR_DOMAIN}/android/com.auth0.Android-Login/callback` into the  **Allowed Callback URLs** and **Allowed Login URLs** fields, replacing `{YOUR_DOMAIN}` with the value you copied from the **Domain** field.
	* Scroll to the bottom of the **Settings** page and click the **Save Changes** button.
* **Configure the app to connect to Auth0:**
	* 	Open the `auth0.xml` string resource file in the app project.
	* Change the contents of the `<string name="com_auth0_scheme">` tag from `TODO: Enter the scheme for your app’s callback and logout URLs here.` to `app`. 
	* Change the contents of the `<string name="com_auth0_domain">` tag from `TODO: Enter your tenant’s domain name here.` to the **Domain** value you copied from the Auth0 dashboard.
	* Change the contents of the `<string name="com_auth0_client_id">` tag from `TODO: Enter your tenant’s domain name here.` to the **Client ID** value you copied from the Auth0 dashboard.
* Run the app!


## License

Copyright (c) 2022 [Auth0](http://auth0.com)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions: The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.