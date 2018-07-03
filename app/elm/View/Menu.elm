module View.Menu exposing (..)

import Html exposing (..)
import Html.Attributes exposing (..)

mainMenu : Html msg
mainMenu =
  div
    [ class "menu" ]
    [ a
      [ href "/listxmls" ]
      [ text "ListXmls" ]
    , a
      [ href "/catvers" ]
      [ text "CatVers" ]
    ]
