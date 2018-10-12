<template>
  <v-app id="inspire">
    <v-navigation-drawer
            :clipped="$vuetify.breakpoint.lgAndUp"
            v-model="sideNav"
            fixed
            app
    >
      <v-list>
        <v-list-tile>
          <v-list-tile-action>
            <flag iso="gb" />
          </v-list-tile-action>
          <v-list-tile-content>Premier League</v-list-tile-content>
        </v-list-tile>
        <v-list-tile>
          <v-list-tile-action>
            <flag iso="de" />
          </v-list-tile-action>
          <v-list-tile-content>Bundesliga</v-list-tile-content>
        </v-list-tile>
        <v-list-tile>
          <v-list-tile-action>
            <flag iso="it" />
          </v-list-tile-action>
          <v-list-tile-content>Serie A</v-list-tile-content>
        </v-list-tile>
        <v-list-tile>
          <v-list-tile-action>
            <flag iso="es" />
          </v-list-tile-action>
          <v-list-tile-content>La Liga</v-list-tile-content>
        </v-list-tile>
      </v-list>
      <v-list-tile>
        <v-list-tile-action>
          <flag iso="nl" />
        </v-list-tile-action>
        <v-list-tile-content>Eredivisie</v-list-tile-content>
      </v-list-tile>
      <v-list-tile>
        <v-list-tile-action>
          <flag iso="it" />
        </v-list-tile-action>
        <v-list-tile-content>Champions League</v-list-tile-content>
      </v-list-tile>
      <v-list-tile>
        <v-list-tile-action>
          <flag iso="it" />
        </v-list-tile-action>
        <v-list-tile-content>Europa League</v-list-tile-content>
      </v-list-tile>
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
        <span class="hidden-sm-and-down">Football Predictions</span>
      </v-toolbar-title>
    </v-toolbar>
  </v-app>
</template>

<script>

    export default {
        data () {
            return {
                sideNav: false
            }
        }
    }
</script>
