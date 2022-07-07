//
// ImageViewExtensions.kt
// Android Kotlin XML Login
// 24 June 2022
//
// From the companion project for the Auth0 blog article\
// “Get Started with Android Authentication Using Kotlin”.
//
// See the end of the file for licensing information.
//


package com.auth0.androidlogin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import java.lang.Exception
import java.util.concurrent.Executors


/**
 * This is a convenience method that asynchronously loads an image
 * from a given URL into an ImageView.
 *
 * @param url The URL where the picture is located.
 */
fun ImageView.loadImage(url: String) {
    val executor = Executors.newSingleThreadExecutor()
    val handler = Handler(Looper.getMainLooper())

    executor.execute {
        try {
            val imageStream = java.net.URL(url).openStream()
            val imageBitmap = BitmapFactory.decodeStream(imageStream)
            handler.post {
                this.setImageBitmap(imageBitmap)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
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