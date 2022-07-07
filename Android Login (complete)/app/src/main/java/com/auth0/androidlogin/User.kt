//
// User.kt
// Android Kotlin XML Login
// 24 June 2022
//
// From the companion project for the Auth0 blog article
// “Get Started with Android Authentication Using Kotlin”.
//
// See the end of the file for licensing information.
//


package com.auth0.androidlogin

import com.auth0.android.jwt.JWT


data class User(val idToken: String? = null) {

    var id = ""
    var name = ""
    var email = ""
    var emailVerified = ""
    var picture = ""
    var updatedAt = ""

    init {
        try {
            // Attempt to decode the ID token.
            val jwt = JWT(idToken ?: "")

            // The ID token is a valid JWT,
            // so extract information about the user from it.
            id = jwt.subject ?: ""
            name = jwt.getClaim("name").asString() ?: ""
            email = jwt.getClaim("email").asString() ?: ""
            emailVerified = jwt.getClaim("email_verified").asString() ?: ""
            picture = jwt.getClaim("picture").asString() ?: ""
            updatedAt = jwt.getClaim("updated_at").asString() ?: ""

        } catch (e: com.auth0.android.jwt.DecodeException) {
            // The ID token is NOT a valid JWT,
            // so leave the user properties as empty strings.
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
