module City ( City, newC, nameC, distanceC )
    where

import Point

data City = Cit String Point deriving (Eq, Show)

newC :: String -> Point -> City
newC = Cit

nameC :: City -> String
nameC (Cit name _) = name

distanceC :: City -> City -> Float
distanceC (Cit name1 poi1)(Cit name2 poi2) = difP poi1 poi2

