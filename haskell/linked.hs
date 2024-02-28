-- Визначення типу даних для LinkedList
data LinkedList a = Empty | Node a (LinkedList a) deriving (Show)

-- Додавання елемента до LinkedList
addToLinkedList :: a -> LinkedList a -> LinkedList a
addToLinkedList x Empty = Node x Empty
addToLinkedList x (Node val next) = Node val (addToLinkedList x next)

-- Перетворення звичайного списку у LinkedList
fromList :: [a] -> LinkedList a
fromList [] = Empty
fromList (x:xs) = Node x (fromList xs)

-- Перетворення LinkedList у звичайний список
toList :: LinkedList a -> [a]
toList Empty = []
toList (Node x next) = x : toList next

-- Сортування LinkedList за зростанням
sortLinkedList :: Ord a => LinkedList a -> LinkedList a
sortLinkedList list = fromList (quickSort (toList list))
  where
    -- Реалізація алгоритму швидкого сортування для списку
    quickSort [] = []
    quickSort (x:xs) =
      let smallerSorted = quickSort [a | a <- xs, a <= x]
          biggerSorted = quickSort [a | a <- xs, a > x]
      in smallerSorted ++ [x] ++ biggerSorted



-- Приклад використання
main = do
    let list = fromList [64, 34, 25, 12, 22, 11, 90]
    print $ sortLinkedList list