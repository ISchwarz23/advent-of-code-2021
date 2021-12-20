package aoc2021

import utils.repeat


object Day20 {

    fun part1(filter: Filter, image: Image): Int {
        val enhancedImage = enhanceImage(image, filter, 2)
        return enhancedImage.numberOfLitPixels
    }

    fun part2(filter: Filter, image: Image): Int {
        val enhanceImage = enhanceImage(image, filter, 50)
        return enhanceImage.numberOfLitPixels
    }

    private fun enhanceImage(image: Image, filter: Filter, enhancementCycles: Int): Image {
        val filterApplier = FilterApplier(filter)
        var resultImage = image
        repeat(enhancementCycles) { resultImage = filterApplier.applyTo(resultImage) }
        return resultImage
    }
}

class FilterApplier(private val filter: Filter) {

    fun applyTo(image: Image): Image {
        val imageWithPadding = image.copyAndAddPadding(filter.size * 2, image.surrounding)
        val newPixels = mutableListOf<List<Char>>()
        for (y in filter.size until imageWithPadding.height - filter.size) {
            val row = mutableListOf<Char>()
            for (x in filter.size until imageWithPadding.width - filter.size) {
                row += filter.applyToPixel(imageWithPadding, x, y)
            }
            newPixels += row
        }
        return Image(newPixels, filter.applyToSurrounding(image.surrounding))
    }
}

class Image(val pixels: List<List<Char>>, val surrounding: Char = '.') {

    val height = pixels.size
    val width = pixels[0].size
    val numberOfLitPixels: Int by lazy {
        if (surrounding == '#') Int.MAX_VALUE
        else pixels.flatten().count { it == '#' }
    }

    fun getSubImage(centerX: Int, centerY: Int, sizeAroundCenter: Int): Image {
        return getSubImage(
            centerX - sizeAroundCenter,
            centerX + sizeAroundCenter,
            centerY - sizeAroundCenter,
            centerY + sizeAroundCenter
        )
    }

    fun getSubImage(fromX: Int, toX: Int, fromY: Int, toY: Int): Image {
        val newPixels = mutableListOf<List<Char>>()
        for (y in fromY..toY) {
            val row = mutableListOf<Char>()
            for (x in fromX..toX) {
                row += pixels[y][x]
            }
            newPixels += row
        }
        return Image(newPixels)
    }

    fun copyAndAddPadding(paddingSize: Int, paddingChar: Char): Image {
        val newPixels: MutableList<List<Char>> = mutableListOf()
        val emptyLine = paddingChar.repeat(width + 2 * paddingSize)
        repeat(paddingSize) { newPixels += emptyLine.toList() }
        for (oldLine in pixels) {
            val newLine = mutableListOf<Char>()
            repeat(paddingSize) { newLine += paddingChar }
            newLine += oldLine
            repeat(paddingSize) { newLine += paddingChar }
            newPixels += newLine
        }
        repeat(paddingSize) { newPixels += emptyLine.toList() }
        return Image(newPixels)
    }

    override fun toString(): String {
        var s = ""
        for (row in pixels) {
            for (pixel in row) {
                s += pixel
            }
            s += "\n"
        }
        return s
    }
}

class Filter(private val data: List<Char>, val size: Int = 1) {

    fun applyToPixel(image: Image, x: Int, y: Int): Char {
        val subImage = image.getSubImage(x, y, size)
        val subImageData = subImage.pixels.flatten().joinToString("")
        return getValueForImageData(subImageData)
    }

    fun applyToSurrounding(surroundingChar: Char): Char {
        val filterAreaSize = size * 2 + 1
        val surroundingData = surroundingChar.repeat(filterAreaSize * filterAreaSize)
        return getValueForImageData(surroundingData)
    }

    private fun getValueForImageData(dataExcerpt: String): Char {
        val index = dataExcerpt.replace('.', '0').replace('#', '1').toInt(2)
        return data[index]
    }
}
