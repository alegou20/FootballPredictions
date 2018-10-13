import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Profile from '@/components/User/Profile'
import SignIn from '@/components/User/SignIn'
import SignUp from '@/components/User/SignUp'
import Standings from '@/components/League/Standings'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/profile',
      name: 'Profile',
      component: Profile
    },
    {
      path: '/signin',
      name: 'SignIn',
      component: SignIn
    },
    {
      path: '/signup',
      name: 'SignUp',
      component: SignUp
    },
      {
          path: '/standings',
          name: 'Standings',
          component: Standings
      }
  ]
})
