Implement the missing code, denoted by ellipses. You may not modify the pre-existing code.
The GoDaddy Website Builder product helps small businesses easily create websites. Let's say we are going to add a feature where the name of a business is automatically placed on top of a large "hero" image on the landing page of the site.

To do so, we need to find a position on the image where the text will be the most readable. If the text is placed on an area of the image that is too dark, it will be difficult for the site visitors to read it (for simplicity's sake, let's only consider black text on a grayscale image). We will define the optimal position of the text as the position where the mean pixel brightness inside the bounding box for the text is maximized.

You are given a grayscale image as a 2D array of pixels with the height and width of the text's rectangular bounding box. You must return the bounding box's top-left corner coordinates for the optimal text position. If there is more than one optimal position, return the top-left-most one.
