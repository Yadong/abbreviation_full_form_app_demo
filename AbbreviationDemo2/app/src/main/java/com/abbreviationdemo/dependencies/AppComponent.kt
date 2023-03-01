package com.abbreviationdemo.dependencies

import com.abbreviationdemo.uis.HomeActivity
import com.abbreviationdemo.uis.HomeFragment
import dagger.Component

@Component(modules = [HttpModule::class])
interface AppComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(homeFragment: HomeFragment)
}
