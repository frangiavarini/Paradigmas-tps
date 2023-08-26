module Region ( Region, newR, foundR, linkR, connectedR, linkedR, delayR, tunelR,availableCapacityForR )
  where

import Point
import City
import Link
import Tunel
import Quality

data Region = Reg [City] [Link] [Tunel] deriving (Show)


newR :: Region
newR = Reg [] [] []


foundR :: Region -> City -> Region
foundR (Reg citiess linkss tunnelss) myCity  
  |myCity `elem` citiess = error " Duplicated City? "
  |otherwise = Reg (myCity : citiess) linkss tunnelss


isLinkBetweenCities :: [Link] -> City -> City -> Bool
isLinkBetweenCities [] _ _ = False
isLinkBetweenCities (l:ls) city1 city2 
  | linksL city1 city2 l = True
  | otherwise = isLinkBetweenCities ls city1 city2


linkR :: Region -> City -> City -> Quality -> Region
linkR (Reg citiess linkss tunnelss) city1 city2 myQuality 
  | isLinkBetweenCities linkss city1 city2 = error "Already existing link."
  | otherwise = 
      let newLink = newL city1 city2 myQuality
      in Reg citiess (newLink : linkss) tunnelss


connectedR :: Region -> City -> City -> Bool
connectedR (Reg _ _ []) _ _ = False
connectedR (Reg _ _ (tunnel1 : rest)) city1 city2 =
  connectsT city1 city2 tunnel1 || connectedR (Reg [] [] rest) city1 city2 


linkedR :: Region -> City -> City -> Bool
linkedR (Reg _ [] _ ) _ _ = False
linkedR (Reg _ (link1 : rest) _ ) city1 city2 =
  linksL city1 city2 link1 || linkedR (Reg [] rest [] ) city1 city2


delayR :: Region -> City -> City -> Float
delayR region city1 city2 =
  let connectedTunnels = filter (\tunnel -> connectedR region city1 city2) (getTunnels region) 
      totalDelay = sum (map delayT connectedTunnels)
  in totalDelay


getTunnels :: Region -> [Tunel]
getTunnels (Reg _ _ tunnels) = tunnels


availableCapacityForR :: Region -> City -> City -> Int
availableCapacityForR (Reg citiess [] _ ) _ _ = error " Non existing links. "
availableCapacityForR reg@(Reg citiess (l:linkss) tunnelss) city1 city2 =
  if linksL city1 city2 l
    then capacityL l - (usedCapacity l (Reg citiess linkss tunnelss) )
    else availableCapacityForR (Reg citiess linkss tunnelss) city1 city2


usedCapacity :: Link -> Region -> Int
usedCapacity link (Reg _ _ tunnelss) = capacityL link - tunnelsInLink link tunnelss


tunnelsInLink :: Link -> [Tunel] -> Int 
tunnelsInLink _ [] = 0
tunnelsInLink l (t:ts) 
  | usesT l t = 1 + tunnelsInLink l ts 
  | otherwise = tunnelsInLink l ts


isCityIn :: [City] -> [City] -> Bool
isCityIn [] _ = True
isCityIn _ [] = error "Empty region."
isCityIn (c:cs) citiess = c `elem` citiess && isCityIn cs citiess


areLinked :: [City] -> [Link] -> Bool
areLinked _ [] = False
areLinked [] _ = error " Cities are currently unavailable. "
areLinked (c1:c2:cs) linkss = any (\l -> linksL c1 c2 l) linkss || areLinked (c2:cs) linkss


linksForTunnel :: [City] -> [Link] -> [Link]
linksForTunnel [_] _ = []
linksForTunnel (c1:c2:cs) linkss = [l | l <- linkss, linksL c1 c2 l] ++ linksForTunnel (c2:cs) linkss


isTunnelIn :: [Tunel] -> Tunel -> Bool 
isTunnelIn tunnelss tunnel = tunnel `elem` tunnelss


tunelR :: Region -> [City] -> Region
tunelR (Reg citiess linkss tunnelss) cities1
  | isCityIn cities1 citiess && areLinked cities1 linkss && not (isTunnelIn tunnelss (newT (linksForTunnel cities1 linkss))) =
    Reg citiess linkss (tunnelss ++ [newT (linksForTunnel cities1 linkss)])
  | otherwise = Reg citiess linkss tunnelss



