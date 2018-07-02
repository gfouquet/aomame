module Main exposing (main)

import Html exposing (..)
import Html.Events exposing (..)
import Navigation as Nav


-- Main
-- ----


main : Program Never Model Msg
main =
  Nav.program UrlChange
    { init = init
    , update = update
    , view = view
    , subscriptions = subscriptions
    }




-- Model
-- ------


type alias Model =
  { text : String
  , history : List Nav.Location
  }


--type Msg
--    = RouteChanged Sitemap
--    | RouteTo Sitemap
--    | NavbarMsg Navbar.State
--    | Fetch (Result Http.Error (List Post))
type Msg
  = UrlChange Nav.Location

init : Nav.Location -> ( Model, Cmd Msg )
init location =
  ( Model "bleh" [location]
  , Cmd.none
  )
--    let
--        ( navbarState, navbarCmd ) =
--            Navbar.initialState NavbarMsg
--
--        initialModel =
--            { route = Routes.parsePath location
--            , navbarState = navbarState
--            , ready = False
--            , posts = []
--            , post = Nothing
--            , error = Nothing
--            }
--
--        ( model, routeCmd ) =
--            handleRoute initialModel.route initialModel
--    in
--        ( model, Cmd.batch [ navbarCmd, routeCmd ] )



-- Subscriptions
-- -------------


subscriptions : Model -> Sub Msg
subscriptions model =
  Sub.none
--    Navbar.subscriptions model.navbarState NavbarMsg



-- Update
-- ------


update : Msg -> Model -> ( Model, Cmd Msg )
update msg model =
  ( Model "plop" model.history
  , Cmd.none
  )
--    case msg of
--        RouteChanged route ->
--            handleRoute route model
--
--        RouteTo route ->
--            model ! [ Routes.navigateTo route ]
--
--        NavbarMsg state ->
--            { model | navbarState = state } ! []
--
--        Fetch (Err error) ->
--            { model | error = Just (toString error) } ! []
--
--        Fetch (Ok posts) ->
--            handleRoute model.route
--                { model
--                    | ready = True
--                    , error = Nothing
--                    , posts = posts
--                }
--
--
--parseRoute : Location -> Msg
--parseRoute =
--    Routes.parsePath >> RouteChanged
--
--
--handleRoute : Sitemap -> Model -> ( Model, Cmd Msg )
--handleRoute route ({ ready } as model) =
--    let
--        newModel =
--            { model | route = route }
--
--        fetchPosts =
--            Task.attempt Fetch Post.fetchPosts
--    in
--        case route of
--            PostsR ->
--                if ready then
--                    newModel ! []
--                else
--                    newModel ! [ fetchPosts ]
--
--            PostR id ->
--                if ready then
--                    { newModel | post = Post.lookupPost id newModel.posts } ! []
--                else
--                    newModel ! [ fetchPosts ]
--
--            _ ->
--                newModel ! []



-- View
-- ----

--view : Model -> Html Msg
view model =
  div [] [text <| "yolo, " ++ model.text]

--view : Model -> Html Msg
--view model =
--    Grid.container []
--        [ navigation model
--        , div [ class "mt-3" ] [ content model ]
--        ]
--
--
--navigation : Model -> Html Msg
--navigation model =
--    Navbar.config NavbarMsg
--        |> Navbar.withAnimation
--        |> Navbar.brand (linkAttrs HomeR) [ text "Example" ]
--        |> Navbar.items
--            [ Navbar.itemLink (linkAttrs HomeR) [ text "Home" ]
--            , Navbar.itemLink (linkAttrs PostsR) [ text "Posts" ]
--            , Navbar.itemLink (linkAttrs AboutR) [ text "About" ]
--            ]
--        |> Navbar.view model.navbarState
--
--
--content : Model -> Html Msg
--content ({ route } as model) =
--    case model.route of
--        HomeR ->
--            home
--
--        PostsR ->
--            if model.ready then
--                posts model.posts
--            else
--                loading
--
--        PostR id ->
--            case ( model.ready, model.post ) of
--                ( False, _ ) ->
--                    loading
--
--                ( True, Nothing ) ->
--                    notFound
--
--                ( True, Just p ) ->
--                    post p
--
--        AboutR ->
--            about
--
--        NotFoundR ->
--            notFound
--
--
--notFound : Html Msg
--notFound =
--    Alert.danger [ text "Page not found" ]
--
--
--home : Html Msg
--home =
--    div []
--        [ H.h3 [ class "mb-2" ] [ text "Home" ]
--        , H.p []
--            [ H.a
--                (linkAttrs <| PostR 123)
--                [ text "Click to fetch post #123 which doesn't exist" ]
--            ]
--        ]
--
--
--about : Html Msg
--about =
--    Alert.info [ text "About page..." ]
--
--
--loading : Html Msg
--loading =
--    Alert.warning [ text "Loading ..." ]
--
--
--post : Post -> Html Msg
--post post =
--    div []
--        [ H.h3 [ class "mb-2" ] [ text post.title ]
--        , H.p [] [ Markdown.toHtml [] post.body ]
--        ]
--
--
--posts : List Post -> Html Msg
--posts posts =
--    let
--        postLink post =
--            H.li [] [ H.a (linkAttrs <| PostR post.id) [ text post.title ] ]
--    in
--        div []
--            [ H.h3 [ class "mb-2" ] [ text "Posts" ]
--            , H.ul [] (List.map postLink posts)
--            ]
--
--
--linkAttrs : Sitemap -> List (H.Attribute Msg)
--linkAttrs route =
--    let
--        onClickRoute =
--            E.onWithOptions
--                "click"
--                { preventDefault = True
--                , stopPropagation = True
--                }
--                (JD.succeed <| RouteTo route)
--    in
--        [ A.href <| Routes.toString route
--        , onClickRoute
--        ]
