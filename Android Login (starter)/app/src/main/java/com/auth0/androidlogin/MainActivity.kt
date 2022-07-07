//
// MainActivity.kt
// Android Kotlin XML Login
// 24 June 2022
//
// From the companion project for the Auth0 blog article
// “Get Started with Android Authentication Using Kotlin”.
//
// See the end of the file for licensing information.
//


package com.auth0.androidlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.google.android.material.snackbar.Snackbar
import com.auth0.androidlogin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // Access to onscreen controls
    private lateinit var binding: ActivityMainBinding

    // App and user status
    // TODO: Add app and user status properties here

    // Auth0 data
    // TODO: Add Auth0 data properties here


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: Add code here.
    }

    private fun login() {

        // TODO: Add code here.

    }

    private fun logout() {

        // TODO: Add code here.

    }

    private fun updateUI() {

        // TODO: Add code here.

    }


    // Utility functions
    // =================

    /**
     * This is a convenience method that simplifies the process
     * of displaying a SnackBar.
     *
     * @param text The text that the SnackBar should display.
     */
    private fun showSnackBar(text: String) {
        Snackbar
            .make(
                binding.root,
                text,
                Snackbar.LENGTH_LONG
            ).show()
    }

}


//
// License information
// ===================
//
// Copyright (c) 2022 Auth0 (http://auth0.com)
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in
// all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
// THE SOFTWARE.