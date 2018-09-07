When visualizing market data over a long period of time, it is often helpful to build an Open-high-low-close (OHLC) chart. However, to build an OHLC chart you first need to prepare some data. For each financial instrument consider each day when it was traded, and find the following prices the instrument had that day:

-open price: the price of the first trade of the day;

-high price: the highest trade of the day;

-low price: the lowest trade of the day;

-close price: the price of the last trade of the day.

Given a stream of trade data ordered by time, write a program to compute the OHLC by day and instrument (see output section for the format details).
If two trades happen to have equal timestamps, then their order is determined by the order of their timestamps in the timestamp array.
