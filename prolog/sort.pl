% bubble_step(+List, -Swapped)
bubble_step([X, Y | Rest], [Y, X | Rest]) :-
% Якщо елемент X більший за Y, то міняємо їх місцями
    X > Y.
bubble_step([X | Rest1], [X | Rest2]) :-
% X менший за Y, тому його не міняємо і переходимо до наступних елементів
    bubble_step(Rest1, Rest2).

% bubble_sort(+List, -Sorted)
bubble_sort(List, Sorted) :-
    % Проводимо один прохід по списку
    bubble_step(List, Swapped),
    !,
    % Рекурсивно викликаємо функцію для списку із виконаним кроком
    bubble_sort(Swapped, Sorted).
% Якщо список відсортований, то повертаємо його
bubble_sort(Sorted, Sorted).

