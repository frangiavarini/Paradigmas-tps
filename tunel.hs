module Tunel ( Tunel, newT, connectsT, usesT, delayT )
  where

import Point
import City
import Quality
import Link

data Tunel = Tun [Link] deriving (Eq, Show)

newT :: [Link] -> Tunel
newT = Tun

connectsT :: City -> City -> Tunel -> Bool
connectsT city1 city2 (Tun links) = any (\link -> linksL city1 city2 link || linksL city2 city1 link) links

usesT :: Link -> Tunel -> Bool
usesT link (Tun links) = link `elem` links

delayT :: Tunel -> Float
delayT (Tun links) = foldl (\acc link -> acc + delayL link) 0.0 links