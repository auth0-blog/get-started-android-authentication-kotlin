package com.example.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.management.ManagementException
import com.auth0.android.management.UsersAPIClient
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.google.android.material.snackbar.Snackbar
import com.example.login.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Login/logout-related properties
    private lateinit var account: Auth0
    private var cachedCredentials: Credentials? = null
    private var cachedUserProfile: UserProfile? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        account = Auth0(
            getString(R.string.com_auth0_client_id),
            getString(R.string.com_auth0_domain)
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener { login() }
        binding.buttonLogout.setOnClickListener { logout() }
        binding.buttonGet.setOnClickListener { getUserMetadata() }
        binding.buttonSet.setOnClickListener { setUserMetadata() }
    }

    private fun login() {
        WebAuthProvider
            .login(account)
            .withScheme(getString(R.string.com_auth0_scheme))
            .withScope(getString(R.string.login_scopes))
            .withAudience(getString(R.string.login_audience, getString(R.string.com_auth0_domain)))
            .start(this, object : Callback<Credentials, AuthenticationException> {

                override fun onFailure(exception: AuthenticationException) {
                    showSnackBar(getString(R.string.login_failure_message, exception.getCode()))
                }

                override fun onSuccess(credentials: Credentials) {
                    cachedCredentials = credentials
                    showSnackBar(getString(R.string.login_success_message, credentials.accessToken))
                    updateUI()
                    showUserProfile()
                }
            })
    }

    private fun logout() {
        WebAuthProvider
            // Build a WebAuthProvider object bit by bit, by specifying
            // 1. Which Auth0 tenant account will be used
            // 2. The callback scheme
            .logout(account)
            .withScheme(getString(R.string.com_auth0_scheme))

            // Take the WebAuthProvider object built by the previous
            // methods in the chain and use it to log the user out.
            // This also defines the callback methods for a failed logout and
            // a successful one.
            .start(this, object : Callback<Void?, AuthenticationException> {

                override fun onFailure(exception: AuthenticationException) {
                    updateUI()
                    showSnackBar(getString(R.string.general_failure_with_exception_code,
                        exception.getCode()))
                }

                override fun onSuccess(payload: Void?) {
                    // The user has been logged out!
                    cachedCredentials = null
                    cachedUserProfile = null
                    updateUI()
                }

            })
    }

    private fun showUserProfile() {
        // Guard against showing the profile when no user is logged in
        if (cachedCredentials == null) {
            return
        }

        val client = AuthenticationAPIClient(account)
        client
            .userInfo(cachedCredentials!!.accessToken!!)
            .start(object : Callback<UserProfile, AuthenticationException> {

                override fun onFailure(exception: AuthenticationException) {
                    showSnackBar(getString(R.string.general_failure_with_exception_code,
                        exception.getCode()))
                }

                override fun onSuccess(profile: UserProfile) {
                    cachedUserProfile = profile
                    updateUI()
                }

            })
    }

    private fun getUserMetadata() {
        // Guard against getting the metadata when no user is logged in
        if (cachedCredentials == null) {
            return
        }

        val usersClient = UsersAPIClient(account, cachedCredentials!!.accessToken!!)

        usersClient
            .getProfile(cachedUserProfile!!.getId()!!)
            .start(object : Callback<UserProfile, ManagementException> {

                override fun onFailure(exception: ManagementException) {
                    showSnackBar(getString(R.string.general_failure_with_exception_code,
                        exception.getCode()))
                }

                override fun onSuccess(userProfile: UserProfile) {
                    cachedUserProfile = userProfile
                    updateUI()

                    val country = userProfile.getUserMetadata()["country"] as String?
                    binding.edittextCountry.setText(country)
                }

            })
    }

    private fun setUserMetadata() {
        // Guard against getting the metadata when no user is logged in
        if (cachedCredentials == null) {
            return
        }

        val usersClient = UsersAPIClient(account, cachedCredentials!!.accessToken!!)
        val metadata = mapOf("country" to binding.edittextCountry.text.toString())

        usersClient
            .updateMetadata(cachedUserProfile!!.getId()!!, metadata)
            .start(object : Callback<UserProfile, ManagementException> {

                override fun onFailure(exception: ManagementException) {
                    showSnackBar(getString(R.string.general_failure_with_exception_code,
                        exception.getCode()))
                }

                override fun onSuccess(profile: UserProfile) {
                    cachedUserProfile = profile
                    updateUI()

                    showSnackBar(getString(R.string.general_success_message))
                }

            })
    }

    private fun updateUI() {
        val isLoggedIn = cachedCredentials != null

        binding.textviewTitle.text = if (isLoggedIn) {
            getString(R.string.logged_in_title)
        } else {
            getString(R.string.logged_out_title)
        }
        binding.buttonLogin.isEnabled = !isLoggedIn
        binding.buttonLogout.isEnabled = isLoggedIn
        binding.linearlayoutMetadata.isVisible = isLoggedIn

        binding.textviewUserProfile.isVisible = isLoggedIn

        val userName = cachedUserProfile?.name ?: ""
        val userEmail = cachedUserProfile?.email ?: ""
        binding.textviewUserProfile.text = getString(R.string.user_profile, userName, userEmail)

        if (!isLoggedIn) {
            binding.edittextCountry.setText("")
        }
    }

    private fun showSnackBar(text: String) {
        Snackbar
            .make(
            binding.root,
            text,
            Snackbar.LENGTH_LONG
        ).show()
    }

}