<template>
  <v-app id="inspire">
    <v-navigation-drawer
            :clipped="$vuetify.breakpoint.lgAndUp"
            v-model="sideNav"
            fixed
            app
    >
      <v-list>
        <v-list-tile v-for="item in menuItems"
                     :key="item.title"
                      router
                      :to="item.link">
          <v-list-tile-action>
            <div style="font-size:15px">
            <flag :iso="item.icon" />
            </div>
          </v-list-tile-action>
            <v-list-tile-content>{{item.title}}</v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar
            :clipped-left="$vuetify.breakpoint.lgAndUp"
            color="green darken-3"
            dark
            app
            fixed
    >
      <v-toolbar-title style="width: 300px" class="ml-0 pl-3">
        <v-toolbar-side-icon @click.stop="sideNav = !sideNav"></v-toolbar-side-icon>
        <router-link to="/" tag="span" style="cursor: pointer">Football Predictions</router-link>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items class="hidden-xs-only">
        <v-btn to="/SignUp" flat>
          <v-icon left dark>face</v-icon>
          signup
        </v-btn>
        <v-btn to="SignIn" flat>
          <v-icon left dark>lock_open</v-icon>
          signin
        </v-btn>
      </v-toolbar-items>
    </v-toolbar>
    <main>
      <router-view></router-view>
    </main>
  </v-app>
</template>

<script>
    export default {
        data () {
            return {
                sideNav: false,
                menuItems:[
                    {icon: 'gb', title: 'Premier League', link: '/Standings'},
                    {icon: 'es', title: 'LaLiga',link: '/Standings'},
                    {icon: 'de', title: 'Bundesliga', link: '/Standings'},
                    {icon: 'it', title: 'Serie A', link: '/Standings'},
                    {icon: 'fr', title: 'Ligue 1', link: '/Standings'},
                    {icon: 'nl', title: 'Eredivisie', link: '/Standings'},
                    {icon: 'nl', title: 'Keuken Kampioen divisie', link: '/Standings'},
                    {icon: 'be', title: 'Jupiler Pro League', link: '/Standings'},
                    {icon: 'eu', title: 'Champions League', link: '/Standings'},
                    {icon: 'eu', title: 'Europa League', link: '/Standings'},
                    {icon: 'eu', title: 'UEFA Nations League', link: '/Standings'}
                ]
            }
        }
    }

</script>
