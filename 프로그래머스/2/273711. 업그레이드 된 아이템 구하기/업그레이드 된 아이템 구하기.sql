SELECT ITEM_ID, ITEM_NAME, RARITY
FROM item_info
WHERE item_id IN (SELECT item_id
                  FROM item_tree
                  WHERE item_tree.parent_item_id
                    IN (SELECT item_id
                        FROM item_info
                        WHERE rarity = 'RARE'))
ORDER BY item_id desc;