module Routes exposing (Sitemap(..), parsePath, navigateTo, toString)

import Navigation exposing (Location)
import Route exposing (..)


type Sitemap
  = Home
  | ListXmls
  | CatVerInis

-- Private functions
-- -----------------

home : Route Sitemap
home =
  route Home (static "")

listXmls : Route Sitemap
listXmls =
  route ListXmls (static "listXmls")

catVerInis : Route Sitemap
catVerInis =
  route CatVerInis (static "catVerInis")

sitemap : Router Sitemap
sitemap =
  router [ home, listXmls, catVerInis ]


-- Public API
-- ----------

match : String -> Maybe Sitemap
match =
  Route.match sitemap


toString : Sitemap -> String
toString route =
  case route of
    Home ->
      reverse home []

    ListXmls ->
      reverse listXmls []

    CatVerInis ->
      reverse catVerInis []


parsePath : Location -> Maybe Sitemap
parsePath =
  .pathname >> match


navigateTo : Sitemap -> Cmd msg
navigateTo =
  toString >> Navigation.newUrl
