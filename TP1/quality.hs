module Quality ( Quality, newQ, capacityQ, delayQ )
     where

data Quality = Qua String Int Float deriving (Eq, Show)

newQ :: String -> Int -> Float -> Quality
newQ = Qua

capacityQ :: Quality -> Int
capacityQ (Qua name int _) = int

delayQ :: Quality -> Float
delayQ (Qua _ _ float) = float
