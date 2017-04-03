on run argv
	set uuid to item 1 of argv
	tell application "DYMO Label"
		
		openLabel in "/Users/emeterio/Documents/DYMO Label Software/Labels/invisibox.label"
		set elem to a reference to last barcode
		tell elem
			set barcodeText to uuid
		end tell
		redrawLabel
		print
		
	end tell
end run