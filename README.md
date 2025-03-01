
# 8x8 Symbol to array converter

This program allows you to draw a symbol on an 8x8 grid, and it then converts said symbol to an array of decimal values. Each of those values represents a row on an 8x8 LED matrix display in binary.

### Example

#### This is the converter gui without anything being done yet.

![Showcase](https://hc-cdn.hel1.your-objectstorage.com/s/v3/7924d34903787392a0994d96b80a9338966af3a0_image.png)

#### We can draw an image on the 8x8 grid.

![Drawing](https://hc-cdn.hel1.your-objectstorage.com/s/v3/6bc7f8dfcf4b4f7cd700f9a1d07202e73caa29d6_image.png)

#### Upon clicking the button, the array gets copied into our clipboard 

![Copy](https://hc-cdn.hel1.your-objectstorage.com/s/v3/a37ffc709ab66df22086af0973d74c29eec65e3f_image.png)

The resulting array looks like this: **{24, 60, 126, 255, 219, 24, 24, 24};**
This corresponds to a binary 8x8 grid:

00011000  
00111100  
01111110  
11111111  
11011011  
00011000  
00011000  
00011000
